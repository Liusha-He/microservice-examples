"""create topics

Revision ID: 24111a5948d4
Revises: 
Create Date: 2021-10-01 19:09:32.769951

"""
from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision = '24111a5948d4'
down_revision = None
branch_labels = None
depends_on = None


def upgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.create_table(
        "topic",
        sa.Column("id", sa.Integer, primary_key=True),
        sa.Column("topic", sa.String(100), nullable=False),
        sa.Column("created_at", sa.DateTime, nullable=False),
        sa.Column("location", sa.String(100), nullable=False),
        sa.Column("event_time", sa.DateTime, nullable=False),
        sa.Column("event_url", sa.String(500), nullable=False),
        sa.Column("insert_dt", sa.DateTime, nullable=False),
    )
    # ### end Alembic commands ###


def downgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.drop_table("topic")
    # ### end Alembic commands ###
